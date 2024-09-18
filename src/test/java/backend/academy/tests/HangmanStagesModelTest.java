package backend.academy.tests;

import backend.academy.hangman.Model.HangmanStagesModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HangmanStagesModelTest {

    @Test
    public void testNextStage() {
        assertEquals(HangmanStagesModel.STAGE_2, HangmanStagesModel.STAGE_1.nextStage());
        assertEquals(HangmanStagesModel.STAGE_3, HangmanStagesModel.STAGE_2.nextStage());
        assertEquals(HangmanStagesModel.STAGE_4, HangmanStagesModel.STAGE_3.nextStage());
        assertEquals(HangmanStagesModel.STAGE_5, HangmanStagesModel.STAGE_4.nextStage());
        assertEquals(HangmanStagesModel.STAGE_6, HangmanStagesModel.STAGE_5.nextStage());
        assertEquals(HangmanStagesModel.STAGE_7, HangmanStagesModel.STAGE_6.nextStage());
    }
}
