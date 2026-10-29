void main() {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> num = new ArrayList<>();
    String input, list = "";

    while (true) {
        System.out.print("Type X to compute or Enter a Number: ");
        input = sc.next();

        if (input.equalsIgnoreCase("X")) {
            break;
        }
        num.add(Integer.parseInt(input));

        list += input + ", ";
        System.out.println(list);
    }
    System.out.println();


    int sum = 0;
    for (int i = 0; i < num.size(); i++) {
        sum += num.get(i);
    }
    System.out.println("Mean: " + (double) sum / num.size());

    double median;
    if (num.size() % 2 == 1) {
        median = num.get(num.size() / 2);
    } else {
        median = (num.get(num.size() / 2 - 1) + num.get(num.size() / 2)) / 2.0;
    }
    System.out.println("Median: " + median);


    int mode = 0;
    int highest = 0;
    for (int i = 0; i < num.size(); i++) {
        int count = 0;

        for (int j = 0; j < num.size(); j++) {
            if (num.get(i).equals(num.get(j))) {
                count++;
            }
        }
        if (count > highest) {
            highest = count;
            mode = num.get(i);
        }
    }
    System.out.println("Mode: " + mode);
}