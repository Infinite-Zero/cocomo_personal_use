
public class COCOMO_java {

    public static String calculate(float[][] table, int n, char[][] mode, int size) throws Exception
    {
        String out = "";
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
            return "";

        out = String.format("The mode is %s", new String(mode[model]));


        // Calculate Effort
        effort = table[model][0] * (float) Math.pow(size, table[model][1]);

        // Calculate Time
        time = table[model][2] * (float) Math.pow(effort, table[model][3]);

        //Calculate Persons Required
        staff = effort / time;

        // Output the values calculated
        out += String.format("\nEffort = %f Person-Month", effort);

        out += String.format("\nDevelopment Time = %f Months", time);

        out += String.format("\nAverage Staff Required = %d Persons", fround(staff));
        return out;
    }

    public static int fround(float x)
    {
        return (int) (x + 0.5);
    }
}
