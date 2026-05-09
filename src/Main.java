
public class Main {
    public static void main(String[] args) {
        Student [] list = {
          new Student("A","A1",1234, 23),
          new Student("B","B1",1224, 23),
          new Student("C","C1",1230, 20),
          new Student("D","D1",1232, 20),
          new Student("E","E1",1214, 23),
          new Student("F","F1",1229, 20),
          new Student("G","G1",1201, 25),
          new Student("H","H1",1235, 25),
          new Student("I","I1",1202, 25),
          new Student("J","J1",1205, 20),
        };
        //1 рівень
//        System.out.println("Масив до сортування:");
//        printList(list);
//        bubbleSort(list);
//        System.out.println("Масив після сортування бульбашкою:");
//        printList(list);
        //2 рівень
//        System.out.println("Масив перед сортуванням:");
//        printList(list);
//        Student[] sortedArray = sortByIndex(list);
//        System.out.println("Масив після сортування по індексам:");
//        printList(sortedArray);
        //3 рівень
        System.out.println("Масив перед сортуванням:");
        printList(list);
        quickMedianSort(list,0,list.length-1);
        System.out.println("Масив після сортування:");
        printList(list);
    }

    public static void bubbleSort(Student [] list){
        for (int i = 0; i < list.length-1; i++) {
            for (int j = 0; j < list.length-i-1; j++) {
                if(list[j].group>list[j+1].group){
                    Student temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
    }
    public static Student[] sortByIndex(Student[] stud) {

        int size = stud.length;
        int index[] = new int[size];

        for (int i = 0; i < size; i++) {
            index[i] = i;
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                int group1 = stud[index[i]].getGroup();
                int group2 = stud[index[j]].getGroup();

                int id1 = stud[index[i]].getStudentID();
                int id2 = stud[index[j]].getStudentID();

                if (group1 > group2 ||
                        (group1 == group2 && id1 > id2)) {

                    int temp = index[i];
                    index[i] = index[j];
                    index[j] = temp;
                }
            }
        }
        Student[] temp = new Student[size];

        for (int i = 0; i < size; i++) {
            temp[i] = stud[index[i]];
        }
        return temp;
    }

    public static void quickMedianSort(Student [] list, int left, int right) {
        if(left < right){
            //якщо 2 елементи
            if(right - left == 1){
                if(list[left].getGroup()>list[right].getGroup()){
                    Student temp = list[left];
                    list[left] = list[right];
                    list[right] = temp;
                }
            }
            else{
                //знайти медіану з 3-х елементів
                median(list, left, right);

                //якщо елементів більше 3-х
                if (right - left != 2) {
                    int q = partition(list, left, right-1);

                    quickMedianSort(list, left, q-1);
                    quickMedianSort(list, q+1, right);
                }
            }
        }
    }
    public static void median(Student [] list, int left, int right) {
        int mid = left + (right - left)/2;
        if (list[mid].getGroup() < list[left].getGroup()) {
            Student temp = list[mid];
            list[mid] = list[left];
            list[left] = temp;
        }
        if(list[left].getGroup()>list[right].getGroup()){
            Student temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
        if (list[mid].getGroup() > list[right].getGroup()) {
            Student temp = list[mid];
            list[mid] = list[right];
            list[right] = temp;
        }

        Student temp1 = list[mid];
        list[mid] = list[right-1];
        list[right-1] = temp1;
    }

    public static int partition(Student [] list, int left, int right) {
        int pivot = list[right].getGroup();

        int i = left;
        int j = right-1;

        while (true){
            while (list[++i].getGroup() < pivot);
            while (list[--j].getGroup() > pivot);
            if (i >= j) {
                break;
            }
            Student temp = list[i];
            list[i] = list[j];
            list[j] = temp;
        }
        Student temp = list[i];
        list[i] = list[right];
        list[right] = temp;
        return i;
    }


        public static void printList(Student [] list){
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

}