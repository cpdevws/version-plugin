package org.crosslibs.plugins.utils

/**
 * @author cpdews (cpdevws@gmail.com)
 */
class TestUtils {

    public static void runAndAssertEqual(String str, Closure code){
        def buffer = new ByteArrayOutputStream()
        def newStdOut = new PrintStream(buffer)
        def oldStdOut = System.out

        System.out = newStdOut
        code.call()
        System.out = oldStdOut

        assert str == buffer.toString().trim()
    }

}
