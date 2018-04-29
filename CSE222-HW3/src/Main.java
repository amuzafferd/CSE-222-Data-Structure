public class Main {

    public static void main(String[] args) {

        try {

            System.out.println("#############################################################");
            System.out.println("###################### TESTS OF PART 1 ######################");
            System.out.println("#############################################################\n");

            GTUComEngCoursesPart1 part1 = new GTUComEngCoursesPart1();

            System.out.println("*********** Test of 'getByCode' method ***********");
            part1.printCourses(part1.getByCode("CSE 241"));
            System.out.println();

            System.out.println("****** Test of 'listSemesterCourses' method ******");
            part1.printCourses(part1.listSemesterCourses(8));
            System.out.println();

            System.out.println("*********** Test of 'getByRange' method **********");
            part1.printCourses(part1.getByRange(3, 5));
            System.out.println();


            System.out.println("#############################################################");
            System.out.println("###################### TESTS OF PART 2 ######################");
            System.out.println("#############################################################\n");

            GTUComEngCoursesPart2 part2 = new GTUComEngCoursesPart2(part1.getAllCourses());


            System.out.println("Size: " + part2.getAllListElements().size());
            System.out.println("*********** Test of 'disable' method **********");
            System.out.println("Disable element: " + part2.disable(0));
            System.out.println("Disable element: " + part2.disable(0));
            System.out.println("Disable element: " + part2.disable(0));
            System.out.println("Disable element: " + part2.disable(0));
            System.out.println();

            System.out.println("*********** Test of 'showDisabled' method **********");
            part2.showDisabled();
            System.out.println();

            System.out.println("*********** Test of 'enable' method **********");
            System.out.println("Enable element: " + part2.enable(0));
            System.out.println("Enable element: " + part2.enable(0));

            System.out.println();
            part2.printCourses(part2.getAllListElements());

            System.out.println("#############################################################");
            System.out.println("###################### TESTS OF PART 3 ######################");
            System.out.println("#############################################################\n");

            GTUComEngCoursesPart3 part3 = new GTUComEngCoursesPart3();

            System.out.println("*********** Test of 'add' and 'next' method **********");
            part3.add(new GTUComEngCourses("8", "CSE 444", "Bilgisayar Aglari","5", "3", "2+0+0"));
            part3.add(new GTUComEngCourses("8", "CSE 551", "aaaaaa", "6", "4", "3+1+0"));
            part3.add(new GTUComEngCourses("9", "CSE 1232", "qweqw", "6", "4", "3+1+0"));
            part3.add(new GTUComEngCourses("9", "CSE 1232", "qweqw", "6", "4", "3+1+0"));
            part3.add(new GTUComEngCourses("9", "CSE 1232", "qweqw", "6", "4", "3+1+0"));
            part3.add(new GTUComEngCourses("8", "CSE ssxswdce", "qweqw", "6", "4", "3+1+0"));

            while (part3.hasNext()) {
                System.out.println(part3.next());
            }

            part3.resetCurrent();
            System.out.println();

            System.out.println("*********** Test of 'remove' method **********");
            part3.remove(2);
            while (part3.hasNext()) {
                System.out.println(part3.next());
            }

            part3.resetCurrent();
            System.out.println();

            System.out.println("*********** Test of 'size' method **********");
            System.out.println("Size of array: " + part3.size());
            System.out.println();

            System.out.println("*********** Test of 'nextInSemester' method **********");
            System.out.println(part3.nextInSemester());
            System.out.println(part3.nextInSemester());
            System.out.println(part3.nextInSemester());


        }catch (Exception e){
            System.err.println("Error: " + e);
        }
    }
}
