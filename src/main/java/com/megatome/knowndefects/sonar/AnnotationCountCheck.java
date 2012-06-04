package com.megatome.knowndefects.sonar;

import com.puppycrawl.tools.checkstyle.api.Check;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

public class AnnotationCountCheck extends Check {

    private int annotationCount = 0;
    private DetailAST classAST = null;

    @Override
    public int[] getDefaultTokens() {
        return new int[]{TokenTypes.CLASS_DEF, TokenTypes.ANNOTATION_DEF};
    }

    @Override
    public void beginTree(DetailAST aRootAST) {
        annotationCount = 0;
        classAST = null;
    }

    @Override
    public void finishTree(DetailAST aRootAST) {
        super.finishTree(aRootAST);
        if (classAST != null) {
            log(classAST.getLineNo(), classAST.getColumnNo(), "Found " + annotationCount + " annotations");
        }
    }

    @Override
    public void visitToken(DetailAST aAST) {
        if (aAST.getType() == TokenTypes.CLASS_DEF) {
            classAST = aAST;
        } else if (aAST.getType() == TokenTypes.ANNOTATION_DEF) {
            annotationCount++;
        }
    }
}
