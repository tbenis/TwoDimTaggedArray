
public class HolidayBonus {
    public HolidayBonus(){

    }

    /** Calculate holiday bonus.
     * @param data
     * @param high
     * @param low
     * @param other
     * @return double[]
     */
    public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other){
        double[] holidayBonus = new double[data.length];
        for (int row = 0; row < holidayBonus.length; row++){
            for (int column = 0; column < data[row].length; column++){
                if (data[row][column] >= 0) {
                    if (data[row][column] == TwoDimRaggedArrayUtility.getHighestInColumn(data, column)){
                        holidayBonus[row] += high;
                    } else if (data[row][column] == TwoDimRaggedArrayUtility.getLowestInColumn(data, column)){
                        holidayBonus[row] += low;
                    } else{
                        holidayBonus[row] += other;
                    }
                }
            }
        }
        return holidayBonus;
    }
    /** Calculate total holiday bonus.
     * @param data
     * @param high
     * @param low
     * @param other
     * @return double
     */
    public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other){
        double[] bonus = calculateHolidayBonus(data, high, low, other);
        double totalHolidayBonus = 0;
        for (int row = 0; row < bonus.length; row++){
            totalHolidayBonus += bonus[row];
        }
        return totalHolidayBonus;
    }

}