class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (initialEnergy > energy[i])
                initialEnergy -= energy[i];
            else {
                a += energy[i] - initialEnergy + 1;
                initialEnergy = 1;
            }
            if (initialExperience > experience[i])
                initialExperience += experience[i];
            else {
                b += experience[i] - initialExperience + 1;
                initialExperience += b + experience[i];
            }
        }
        return a + b;
    }
}