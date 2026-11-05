class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int start = 0;  // Candidate starting station
        int tank = 0;   // Current journey's accumulated fuel
        int total = 0;  // Total gas surplus across all stations

        for (int i = 0; i < gas.length; i++) {

            // Net fuel gained at this station
            int gain = gas[i] - cost[i];

            // Track total surplus across all stations
            total += gain;

            // Track fuel accumulated from our current start
            tank += gain;

            // If tank becomes negative, current journey is impossible
            if (tank < 0) {

                // None of the stations from 'start' through 'i'
                // can be a valid starting point.
                start = i + 1;

                // Reset fuel and begin a new journey
                tank = 0;
            }
        }

        // If total surplus is negative, completing the circuit is impossible
        return total < 0 ? -1 : start;
    }
}