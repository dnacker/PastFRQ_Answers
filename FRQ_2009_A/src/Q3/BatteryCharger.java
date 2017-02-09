package Q3;

/**
 * Solutions to Question 3.
 */
public class BatteryCharger {
    /** rateTable has 24 entries representing the charging costs for hours 0 through 23. */
    private int[] rateTable;

    public BatteryCharger(int[] rates) {
        rateTable = rates;
    }

    /** Determines the total cost to charge the battery starting at the beginning of startHour.
     * @param startHour the hour at which the charge period begins
     * Precondition: 0 ≤ startHour ≤ 23
     * @param chargeTime the number of hours the battery needs to be charged
     * Precondition: chargeTime > 0
     * @return the total cost to charge the battery
     */
    public int getChargingCost(int startHour, int chargeTime) {
        int totalCost = 0;
        for (int i = 0; i < chargeTime; i++) {
            totalCost += rateTable[(startHour + i) % 24];
        }
        return totalCost;
    }

    /** Determines start time to charge the battery at the lowest cost for the given charge time.
     * @param chargeTime the number of hours the battery needs to be charged
     * Precondition: chargeTime > 0
     * @return an optimal start time, with 0 ≤ returned value ≤ 23
     */
    public int getChargeStartTime(int chargeTime) {
        int smallest = getChargingCost(0, chargeTime);
        int startTime = 0;
        for (int i = 1; i < 24; i++) {
            if (getChargingCost(i, chargeTime) < smallest) {
                smallest = getChargingCost(i, chargeTime);
                startTime = i;
            }
        }
        return startTime;
    }

    public static void main(String[] args) {
        BatteryCharger test = new BatteryCharger(new int[]{50, 60, 160, 60, 80, 100, 100, 120, 150, 150,
                150, 200, 40, 240, 220, 220, 200, 200, 180, 180, 140, 100, 80, 60});
        System.out.println(test.getChargingCost(12, 1));
        System.out.println(test.getChargingCost(0, 2));
        System.out.println(test.getChargingCost(22, 7));
        System.out.println(test.getChargingCost(22, 30));

        System.out.println(test.getChargeStartTime(1));
        System.out.println(test.getChargeStartTime(2));
        System.out.println(test.getChargeStartTime(7));
        System.out.println(test.getChargeStartTime(30));

    }
}
