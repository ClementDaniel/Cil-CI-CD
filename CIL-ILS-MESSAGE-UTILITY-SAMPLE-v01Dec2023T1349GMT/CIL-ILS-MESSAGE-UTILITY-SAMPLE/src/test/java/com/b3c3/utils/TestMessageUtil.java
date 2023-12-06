package com.b3c3.utils;

import org.junit.Test;
import org.junit.rules.TestName;
//import org.junit.Ignore;
import org.junit.Before;
import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;


public class TestMessageUtil {
    MessageUtil messageUtil = new MessageUtil();

    @Rule
    public TestName testName = new TestName();

    @Before
    public void BeforeTests(){
        System.out.println("\n-----------------------------------------------");
        System.out.println("[Unit Test Info] Running Test: " + this.testName.getMethodName() + "\n");
    }

    @Test
    public void testPrintMessageWithEmptyStringPrintsDefaultMessage() {
        String defaultMsg = "I am the default Message";
        MessageUtil messageUtil = new MessageUtil(defaultMsg);
        assertEquals(defaultMsg, messageUtil.printMessage());
    }

    @Test
    public void testInitialMessageIsTrimmed(){
        String wsMsg = "   White Space to begin and end  ";
        MessageUtil messageUtil = new MessageUtil(wsMsg);
        assertEquals(wsMsg.trim(), messageUtil.printMessage());
    }

    @Test
    public void testPrintMessagePrintsExpectedMessage() {
        String msg2Print = "Print This Expected Message Please";
        assertEquals(msg2Print, messageUtil.printMessage(msg2Print));
    }
    
    @Test
    public void testDefaultConstructorIsCreatedWithDefaultMessage() {        
        String[] defaultMsgSnippets = {
            "Hi there!", "I'd greet you properly", 
            "You can run me with", "<your-name>"
        };
        MessageUtil messageUtil = new MessageUtil();
        String printedMsg = messageUtil.printMessage();

        assertThat(printedMsg, allOf(
            containsString(defaultMsgSnippets[0]),
            containsString(defaultMsgSnippets[1]),
            containsString(defaultMsgSnippets[2]),
            containsString(defaultMsgSnippets[3])
        ));
    }

    @Test
    public void testSalutationMessage(){
        String who2Salute = "Peskileenaronika";
        String expectedSalutationMsg = new StringBuilder()
            .append("Hi! ").append(who2Salute)
            .append(".... Nice to meet you!")
            .toString();
        
        assertEquals(expectedSalutationMsg, messageUtil.salutationMessage(who2Salute));
    }

}