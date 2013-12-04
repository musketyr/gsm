package org.gaelyk.gsm

import spock.lang.Specification

class ScriptMethodTransformationSpec extends Specification {

    def "New script class is created"() {
        GroovyShell shell = new GroovyShell()
        
        when:
        Class generatedScriptClass = shell.evaluate("""
        
        package com.example

        class Holder {

            @org.gaelyk.gsm.ScriptMethod
            static String serve() {

            }

        }

        Class.forName('com.example.serve')
        
        """)
        
        then:
        generatedScriptClass
        Script.isAssignableFrom generatedScriptClass
    }
    
    
}
