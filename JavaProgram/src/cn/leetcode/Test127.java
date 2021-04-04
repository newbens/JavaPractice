package cn.leetcode;

import java.util.*;

//���ʽ���
public class Test127 {
    public static void main(String[] args) {
        String bw = "hit";
        String ew = "cog";
        String[] wl = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, wl);
        int res = slove(bw, ew,stringList);
        System.out.println(res);
    }

    public static int slove(String beginWord, String endWord, List<String> wordList) {
        // �Ƚ� wordList �ŵ���ϣ��������ж�ĳ�������Ƿ��� wordList ��
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // ͼ�Ĺ�����ȱ���������ʹ�õĶ��кͱ�ʾ�Ƿ���ʹ��� visited �����飬��ϣ��
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int wordLen = beginWord.length();
        // ������㣬��˳�ʼ����ʱ����Ϊ 1
        int step = 1;
        while (!queue.isEmpty()) {

            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // ���α�����ǰ�����еĵ���
                String word = queue.poll();
                char[] charArray = word.toCharArray();

                // �޸�ÿһ���ַ�
                for (int j = 0; j < wordLen; j++) {
                    // һ���Ժ�Ӧ�����ã�����������ȷ
                    char originChar = charArray[j];

                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originChar) {
                            continue;
                        }

                        charArray[j] = k;
                        String nextWord = String.valueOf(charArray);

                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }

                            if (!visited.contains(nextWord)) {
                                queue.add(nextWord);
                                // ע�⣺��ӵ������Ժ󣬱������ϱ��Ϊ�Ѿ�����
                                visited.add(nextWord);
                            }
                        }
                    }
                    // �ָ�
                    charArray[j] = originChar;
                }
            }
            step++;
        }
        return 0;
    }

}
