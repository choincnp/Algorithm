import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        LinkedList<String> participantAL = new LinkedList<>(Arrays.asList(participant));
        ArrayList<String> completionAL = new ArrayList<>(Arrays.asList(completion));
        // for (String people : participant) participantAL.add(people);
        // for (String people : completion) participantAL.remove(people);
        // participantAL.removeAll(completionAL);
        Iterator<String> it = completionAL.iterator();
        while (it.hasNext()){
            participantAL.remove(it.next());
        }
        return participantAL.get(0);
    }
}