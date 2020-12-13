public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) {
            return false;
        }
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five <= 0) return false;
                five--;
                ten++;
            } else {
                // 优先找 (10, 5), 没有再找 (5, 5, 5)
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}