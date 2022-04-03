package com.memo.app.value

import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Specification

import java.time.LocalDateTime

class CardListTest extends Specification {

    def 'getterから取得できること'() {
        when:
        def testObject1 = new Card(1, 'hoge', 'fuga', LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 1, 0, 0), false)
        def testObject2 = new Card(2, 'hoge', 'fuga', LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 1, 0, 0), false)

        def testObject = Arrays.asList(testObject1, testObject2)

        then:
        testObject.get(0).getCardId() == 1
        testObject.get(0).getCardName() == 'hoge'
        testObject.get(0).getOverview() == 'fuga'
        testObject.get(0).getInsertTime() == LocalDateTime.of(2022, 1, 1, 0, 0)
        testObject.get(0).getUpdatedTime() == LocalDateTime.of(2022, 1, 1, 0, 0)
        testObject.get(0).getDeleteFlag() == false
        testObject.get(1).getCardId() == 2
        testObject.get(1).getCardName() == 'hoge'
        testObject.get(1).getOverview() == 'fuga'
        testObject.get(1).getInsertTime() == LocalDateTime.of(2022, 1, 1, 0, 0)
        testObject.get(1).getUpdatedTime() == LocalDateTime.of(2022, 1, 1, 0, 0)
        testObject.get(1).getDeleteFlag() == false
    }

    def 'jsonシリアライズできること'() {
        when:
        def testObject1 = new Card(1, 'hoge', 'fuga', LocalDateTime.of(2022, 1, 1, 0, 0), LocalDateTime.of(2022, 1, 1, 0, 0), false)

        def testObject = Arrays.asList(testObject1)
        def mapper = new ObjectMapper()
        def actual = mapper.writeValueAsString(testObject)

        def expected = '''[{"cardId":1,"cardName":"hoge","overview":"fuga","insertTime":[2022,1,1,0,0],"updatedTime":[2022,1,1,0,0],"deleteFlag":false}]'''

        then:
        actual == expected
    }

}
