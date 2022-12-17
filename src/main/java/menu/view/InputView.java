package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {
    private final String ASK_COACH_NAME = "코치의 이름을 입력해 주세요. (,로 구분)";
    private final String DELIMITER = ",";
    private final String MULTIPLE_INPUT_REGEX = "^[ㄱ-ㅎ가-힣,]*$";
    private final String ASK_DISLIKE_FOOD = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String readCoachName() {
        System.out.println(ASK_COACH_NAME);
        return readMultipleData(Console.readLine());
    }

    private String readMultipleData(String input) {
        if (!input.contains(DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 구분자는 , 를 사용해야 합니다.");
        }
        if (!Pattern.matches(MULTIPLE_INPUT_REGEX, input)) {
            throw new IllegalArgumentException("[ERROR] 한글과 , 만 입력할 수 있습니다.");
        }
        return input;
    }
    //못먹는 메뉴가 없어서 빈칸 입력받는 경우도 체크 한다
}
