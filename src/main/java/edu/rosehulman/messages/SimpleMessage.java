package edu.rosehulman.messages;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.MessageCorrelationBuilder;
import org.camunda.bpm.model.bpmn.instance.MessageEventDefinition;
import org.camunda.bpm.model.bpmn.instance.ThrowEvent;

import java.util.logging.Logger;

/**
 * Created by mhays on 7/1/16.
 */
public class SimpleMessage implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        // inferring message name from the originating UML node beats copy/pasting boilerplate code
        ProcessEngine processEngine = BpmPlatform.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ThrowEvent e = (ThrowEvent) execution.getBpmnModelElementInstance();
        MessageEventDefinition eventDefinition = (MessageEventDefinition) e.getEventDefinitions().iterator().next();

        // now build message
        String messageName = eventDefinition.getMessage().getName();
        MessageCorrelationBuilder b = runtimeService.createMessageCorrelation(messageName);
        // FIXME: crashes if you don't enter business key
        if (execution.getProcessBusinessKey() != null) {
            Logger.getLogger("SimpleMessage").info("Reusing key: " + execution.getProcessBusinessKey());
            b = b.processInstanceBusinessKey(execution.getProcessBusinessKey());
        } else {
            // This process is MISSING a business key. That's bad.
            Logger.getLogger("SimpleMessage").warning("Business key missing from message: " + messageName);
        }
        b.setVariables(execution.getVariables())
                .correlate();
    }
}
