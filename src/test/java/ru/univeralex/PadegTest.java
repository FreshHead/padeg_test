package ru.univeralex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import padeg.lib.Padeg;
import org.junit.Assert;

/**
 * Created by san on 5/4/17.
 */
public class PadegTest {

  @Test
  public void simpleTest() {
    String[] antonManCases = {"Человек-Антон", "Человека-Антона", "Человеку-Антону", "Человека-Антона","Человеком-Антоном","Человеке-Антоне"};
    System.out.println(Arrays.toString(getAllWordCases(antonManCases[0])));
    Assert.assertArrayEquals(antonManCases, getAllWordCases("Человек-Антон"));
//    printAllCases("Человек-Антон");
//    printAllCases("острые когти");
//    printAllCases("испепеляющий взгляд");
  }

  private String[] getAllPhraseCases(String phrase) {
    String splitter = phrase.contains("-")? "-":" ";
    String[] words = phrase.split(splitter);
    Map<String, String[]> wordCasesMap = new HashMap<String, String[]>();
    String[] phraseCases = new String[6];
    for (String word : words) {
      wordCasesMap.put(word,  getAllWordCases(word));
    }
//todo: Как соединить разбитое сочетание слов снова, но уже в виде массива падежей?
    return phraseCases;
  }

  private String[] getAllWordCases(String word) {

    int padegTypes = 6;
    String[] cases = new String[6];
    for(int i = 0; i < padegTypes; i++) {
      cases[i] = Padeg.getOfficePadeg(word, i+1);
    }
    return cases;
  }
}
