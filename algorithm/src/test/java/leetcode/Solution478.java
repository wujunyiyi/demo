package leetcode;

import java.util.Random;

/**
 * @aurhor Adam Wu
 * @date 2022-06-06 14:33:25
 */
public class Solution478 {
    double x, y, r;
    Random random;

    public Solution478(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
        random = new Random();
    }

    public double[] randPoint() {
        double len = random.nextDouble() * 2 * Math.PI, ang = Math.sqrt(random.nextDouble() * r * r);
        return new double[]{x + Math.cos(len) * ang, y + Math.sin(len) * ang};
    }
}
