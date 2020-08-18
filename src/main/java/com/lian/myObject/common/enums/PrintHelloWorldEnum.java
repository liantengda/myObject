package com.lian.myObject.common.enums;

/**
 * @author Ted
 * @date 2020/8/18 11:15
 */
public enum PrintHelloWorldEnum implements PrintHelloWorldInterface{



    PYTHON("python"){
        @Override
        public String printHelloWorld() {

            return HELLO+getExpectedHello();
        }
    },

    JAVA ("java"){
        @Override
        public String printHelloWorld() {
            return HELLO+getExpectedHello();
        }
    },

    PHP ("php"){
        @Override
        public String printHelloWorld() {
            return HELLO+getExpectedHello();
        }
    },

    JAVASCRIPT("javascript") {
        @Override
        public String printHelloWorld() {
            return HELLO+getExpectedHello();
        }
    };


    private static final String HELLO = "hello ";

    public abstract String printHelloWorld();


    private String expectedHello;


    PrintHelloWorldEnum(String expectedHello){
        this.expectedHello = expectedHello;
    }

    public String getExpectedHello(){
        return expectedHello;
    }


    public static void main(String[] args) {
        String s = PrintHelloWorldEnum.JAVASCRIPT.printHelloWorld();
        System.out.println(s);

        String s1 = PrintHelloWorldEnum.PHP.printHelloWorld();
        System.out.println(s1);

        String s2 = PrintHelloWorldEnum.PYTHON.printHelloWorld();
        System.out.println(s2);

        String s3 = PrintHelloWorldEnum.JAVA.printHelloWorld();
        System.out.println(s3);
    }
}
