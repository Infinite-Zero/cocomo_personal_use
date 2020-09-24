public class COCOMO_java {

    public static void main(String[] args) throws Exception
    {
        // write your code here
        float[][] table = {
                {2.4f, 1.05f, 2.5f, 0.38f},
                {3.0f, 1.12f, 2.5f, 0.35f},
                {3.6f, 1.20f, 2.5f, 0.32f}};

        //char mode[][15]={"Organic","Semi-Detached","Embedded"};

        char[][] mode = new char[4][15];
        mode[0] = "Organic".toCharArray();
        mode[1] = "Semi-Detached".toCharArray();
        mode[2] = "Embedded".toCharArray();

        int size = 4;
        calculate(table, 3, mode, size);
        //System.out.println("EOP");
    }

    public static void calculate(float[][] table, int n, char[][] mode, int size) throws Exception
    {
        if (table[0].length != 4){
            throw new Exception("too many initializers for");
        }

        for (char[] arr : mode){
            if (arr.length > 15)
                throw new Exception("initializer-string for array of chars is too long");
        }

        float effort, time, staff;

        int model = -1;

        // Check the mode according to size
        if (size >= 2 && size <= 50)
            model = 0;     //organic

        else
            if (size > 50 && size <= 300)
                model = 1;     //semi-detached

            else
                if (size > 300)
                    model = 2;     //embedded

        if (model == -1)
            return;

        System.out.printf("The mode is %s", new String(mode[model]));

        // Calculate Effort
        effort = table[model][0] * (float) Math.pow(size, table[model][1]);

        // Calculate Time
        time = table[model][2] * (float) Math.pow(effort, table[model][3]);

        //Calculate Persons Required
        staff = effort / time;

        // Output the values calculated
        System.out.printf("\nEffort = %f Person-Month", effort);

        System.out.printf("\nDevelopment Time = %f Months", time);

        System.out.printf("\nAverage Staff Required = %d Persons", fround(staff));
    }

    public static int fround(float x)
    {
        return (int) (x + 0.5);
    }
}
