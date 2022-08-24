package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] inOrder, postOrder;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        inOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();
        postOrder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
            .toArray();


        getPreorder(0, n - 1, 0, n - 1);

        wr.flush();
        wr.close();
        br.close();
    }

    private static void getPreorder(int is, int ie, int ps, int pe) throws IOException {
        if (is <= ie && ps <= pe) {
            int root = postOrder[pe];
            wr.write(root + " ");

            // iRootIdx 앞 뒤로 좌트리 우트리
            int iRootIdx = -1;
            for (int i = is; i <= ie; i++) {
                if (inOrder[i] == root) {
                    iRootIdx = i;
                    break;
                }
            }

            // 왼쪽 서브트리
            getPreorder(is, iRootIdx - 1, ps, ps + iRootIdx - 1 - is);
            // 오른쪽 서브트리
            getPreorder(iRootIdx + 1, ie, ps + iRootIdx - is, pe - 1);
        }
    }


}

