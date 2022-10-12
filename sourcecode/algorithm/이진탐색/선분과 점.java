package org.example;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        double Ax = Double.parseDouble(st.nextToken());
        double Ay = Double.parseDouble(st.nextToken());
        double Az = Double.parseDouble(st.nextToken());
        double Bx = Double.parseDouble(st.nextToken());
        double By = Double.parseDouble(st.nextToken());
        double Bz = Double.parseDouble(st.nextToken());
        double Cx = Double.parseDouble(st.nextToken());
        double Cy = Double.parseDouble(st.nextToken());
        double Cz = Double.parseDouble(st.nextToken());

        double minLen = Double.MAX_VALUE;
        double ac = calculate(Ax, Ay, Az, Cx, Cy, Cz);
        double bc = calculate(Bx, By, Bz, Cx, Cy, Cz);

        while (true) {
            double mx = (Ax + Bx) / 2;
            double my = (Ay + By) / 2;
            double mz = (Az + Bz) / 2;

            double mc = calculate(mx, my, mz, Cx, Cy, Cz);

            if (Math.abs(mc - minLen) <= 0.0000001) {
                break;
            }

            minLen = Math.min(minLen, mc);

            if (ac <= bc) {
                Bx = mx;
                By = my;
                Bz = mz;
                bc = mc;
            } else {
                Ax = mx;
                Ay = my;
                Az = mz;
                ac = mc;
            }
        }

        wr.write(String.format("%.10f", minLen));
        wr.flush();
        wr.close();
        br.close();
    }

    public static double calculate(double a, double b, double c, double x, double y, double z) {
        return Math.sqrt(Math.pow(a - x, 2) + Math.pow(b - y, 2) + Math.pow(c - z, 2));
    }

}

