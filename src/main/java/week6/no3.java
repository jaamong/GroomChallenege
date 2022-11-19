package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class StringToken {
    String s;
    String token;
    String ED;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getED() {
        return ED;
    }

    public void setED(String ED) {
        this.ED = ED;
    }
}

public class no3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        ArrayList<StringToken> stringTokens = new ArrayList<>();
        for (int i = 0; i < testCase; i++) {
            StringToken mk = new StringToken();
            mk.setS(br.readLine());

            String token = br.readLine();
            mk.setED(token.substring(0, 1));
            mk.setToken(token.substring(2));

            stringTokens.add(mk);
        }

        //문자열이랑 토큰 길이 비교
        for (StringToken st : stringTokens) {
            if (st.getS().length() != st.getToken().length()) {

                String s = st.getS();
                String token = st.getToken();

                StringBuilder sb = new StringBuilder();
                while (s.length() != token.length()) {
                    sb.append(token);
                    token = sb.toString();
                }
                st.setToken(token);
            }
        }

        //암호화/복호화
        for (StringToken st : stringTokens) {
            StringBuilder sb = new StringBuilder();

            int len = st.getS().length();
            if (st.getED().equals("E")) { //암호화
                for (int i = 0; i < len; i++) {

                    char c = st.getS().charAt(i);
                    char t = st.getToken().charAt(i);

                    if ('a' <= c && c <= 'z') c = (char) ((c + t - 'a') % 26 + 'a');
                    if ('A' <= c && c <= 'Z') c = (char) ((c + t - 'A') % 26 + 'A');

                    sb.append(c);
                }
            } else { //복호화
                for (int i = 0; i < len; i++) {

                    char c = st.getS().charAt(i);
                    char t = st.getToken().charAt(i);

                    if ('a' <= c && c <= 'z') c = (char) ((c + (26 - t % 26) - 'a') % 26 + 'a');
                    if ('A' <= c && c <= 'Z') c = (char) ((c + (26 - t % 26) - 'A') % 26 + 'A');

                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
    }
}