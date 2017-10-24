package demo;

import java.util.ArrayList;

public class MyDemo {
        public class MyString {
                String s;
                public MyString(String s) {
                        this.s = s;
                }
                @Override public String toString() {
                        return String.format("%s: %s", this.getClass().getSimpleName(), s);
                }
        }
        
        public class MyLongString extends MyString {
                public MyLongString(String s) {
                        super(s);
                }               
        }

        public class MyExtraLongString extends MyLongString {
                public MyExtraLongString(String s) {
                        super(s);
                }               
        }

        public class MyExtraExtraLongString extends MyExtraLongString {
                public MyExtraExtraLongString(String s) {
                        super(s);
                }               
        }
        
        public class MyLongestString extends MyExtraExtraLongString {
                public MyLongestString(String s) {
                        super(s);
                }               
        }
        
        public class MyList<T extends MyLongString> extends ArrayList<T> {
                private static final long serialVersionUID = 1L;
                public void copyAll(MyList<T> input) {
                        this.addAll(input);
                }
        }

        public static void main(String[] args) {
                MyDemo d = new MyDemo();
                MyString ms = d.new MyString("A");
                System.out.println(ms);
                MyLongString mls = d.new MyLongString("A");
                System.out.println(mls);
                MyExtraLongString mels = d.new MyExtraLongString("A");
                System.out.println(mels);
                MyExtraExtraLongString meels = d.new MyExtraExtraLongString("A");
                System.out.println(meels);
                MyLongestString mest = d.new MyLongestString("A");
                System.out.println(mest);
                
                MyList<MyLongString> myList = d.new MyList<>();
                MyList<MyExtraLongString> myExtraLongList = d.new MyList<>();
                MyList<? super MyLongString> xList = d.new MyList<>();
                //myExtraLongList.add(ms);
                myExtraLongList.add(mels);
                myExtraLongList.add(meels);
                myList.addAll(myExtraLongList);//The addAll method already supports ? extends T
                xList.addAll(myExtraLongList);
                //xList.copyAll(myExtraLongList);
        }

}
