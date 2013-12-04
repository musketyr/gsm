package org.gaelyk.gsm

import java.lang.reflect.Modifier

import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.ast.AnnotationNode
import org.codehaus.groovy.ast.ClassHelper
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.transform.AbstractASTTransformation
import org.codehaus.groovy.transform.GroovyASTTransformation

@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
class ScriptMethodTransformation extends AbstractASTTransformation {

    @Override public void visit(ASTNode[] nodes, SourceUnit source) {
        if (nodes.length != 2 || !(nodes[0] instanceof AnnotationNode) || !(nodes[1] instanceof MethodNode)) {
            println "Internal error: expecting [AnnotationNode, ClassNode] but got: ${Arrays.asList(nodes)}"
        }

        AnnotationNode anno = (AnnotationNode) nodes[0]
        MethodNode parent = (MethodNode) nodes[1]
        
        source.AST.addClass(new ClassNode(parent.declaringClass.packageName + '.' + parent.name, Modifier.PUBLIC, ClassHelper.DYNAMIC_TYPE))
    }
}
