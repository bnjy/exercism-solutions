
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        for(int i = 0; i < birdsPerDay.length; i++){
            //birdsPerDay[i];
            System.out.println(birdsPerDay[i]);
        }
        return birdsPerDay;
    }

    public int getToday() {
        int value = 0;
        if(birdsPerDay.length == 0){
            return value;
        } else{
           value = birdsPerDay[birdsPerDay.length-1];
    }
        return value;
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length-1] = birdsPerDay[birdsPerDay.length-1] + 1;
    }

    public boolean hasDayWithoutBirds() {
        for(int i = 0; i < birdsPerDay.length; i++){
            if(birdsPerDay[i] == 0){
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int count = 0;
        if(numberOfDays > 7){
            numberOfDays = 7;
        }
        for(int i = 0; i<numberOfDays; i++){
            count += birdsPerDay[i];
        }
        return count;
    }

    public int getBusyDays() {
        int busyDays = 0;
        for(int i = 0; i<birdsPerDay.length; i++){
            if(birdsPerDay[i] >= 5){
                busyDays += 1;
            }
        }
        return busyDays;
    }
}
