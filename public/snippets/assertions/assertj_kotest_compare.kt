import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.assertions.withClue
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.collections.shouldContainNull
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.collections.shouldMatchEach
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.date.shouldBeBefore
import io.kotest.matchers.date.shouldHaveSameYearAs
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.ints.shouldNotBeInRange
import io.kotest.matchers.maps.shouldContain
import io.kotest.matchers.maps.shouldContainAll
import io.kotest.matchers.maps.shouldContainExactly
import io.kotest.matchers.maps.shouldContainKey
import io.kotest.matchers.maps.shouldContainValue
import io.kotest.matchers.maps.shouldMatchAll
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.optional.shouldBePresent
import io.kotest.matchers.result.shouldBeSuccess
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldBeEqualIgnoringCase
import io.kotest.matchers.string.shouldBeFalsy
import io.kotest.matchers.string.shouldBeInteger
import io.kotest.matchers.string.shouldBeTruthy
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.string.shouldContainIgnoringCase
import io.kotest.matchers.string.shouldContainOnlyDigits
import io.kotest.matchers.string.shouldContainOnlyOnce
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.string.shouldMatch
import io.kotest.matchers.string.shouldNotBeBlank
import io.kotest.matchers.string.shouldStartWith
import io.kotest.matchers.string.startWith
import io.kotest.matchers.throwable.shouldHaveCauseInstanceOf
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldBeTypeOf
import org.assertj.core.api.Assertions.within
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.Optional
import org.assertj.core.api.Assertions as AssertJ
import org.junit.jupiter.api.Assertions as JUnit

class AssertionsTrade {

    @Test
    fun std_fail() {
        assert(2 == 3)
    }

    @Test
    fun junit_fail() {
        JUnit.assertEquals(2, 3)
    }

    @Test
    fun assertj_fail() {
        AssertJ.assertThat(2).isEqualTo(3)
    }

    @Test
    fun kotest_fail() {
        2 shouldBe 3
    }

    // Но работает только для kotest assertions (те моки упадут без сообщения из clue)
    private inline fun <R> Given(message: String = "", thunk: () -> R) = withClue("Given: $message", thunk)
    private inline fun <R> When(message: String = "", thunk: () -> R) = withClue("When: $message", thunk)
    private inline fun <R> Then(message: String = "", thunk: () -> R) = withClue("Then: $message", thunk)

    @Test
    fun simple_assert() {
        // std assert
        assert(2 == 2)
        assert(2 != 3)

        // JUnit
        JUnit.assertEquals(2, 2)
        JUnit.assertNotEquals(2, 3)

        // Assertj
        AssertJ.assertThat(2).`as`("Then").isEqualTo(3)
        AssertJ.assertThat(2).isNotEqualTo(1)

        // Kotest
        2 shouldBe 2
        1 shouldNotBe 2
        "expected".shouldNotBeNull()

        Then { 2 shouldBe 3 }
    }

    @Test
    fun range_assert() {
        // JUnit
        JUnit.assertTrue(2 in 2..3)

        // Assertj Аргументы входные (expected, offset)
        AssertJ.assertThat(1).isCloseTo(2, within(1))
        AssertJ.assertThat(5).isNotCloseTo(2, within(2))

        // kotest
        1 shouldBeInRange 1..2
        1 shouldNotBeInRange 3..4
    }

    @Test
    fun string_assert() {
        val expected = "1"
        val actual = "123"

        // AssertJ
        AssertJ.assertThat(expected).isNotBlank()
        AssertJ.assertThat(actual).containsPattern(".*")
        AssertJ.assertThat(actual).contains(expected)
        AssertJ.assertThat(actual).containsIgnoringCase(expected)
        AssertJ.assertThat(actual).containsOnlyOnce(expected)

        AssertJ.assertThat(actual).containsOnlyDigits()

        AssertJ.assertThat(actual).startsWith("1")
        AssertJ.assertThat(actual).endsWith("3")

        AssertJ.assertThat(actual).matches(".*")
        AssertJ.assertThat("aab").isEqualToIgnoringCase("AAb")

        // kotest
        expected.shouldNotBeBlank()
        actual shouldContain Regex(".*")
        actual shouldContain expected
        actual shouldContainIgnoringCase expected
        actual shouldContainOnlyOnce expected

        actual.shouldBeInteger()
        actual.shouldContainOnlyDigits()

        actual.shouldStartWith("1")
        actual.shouldEndWith("3")

        actual shouldMatch Regex(".*")
        "aab" shouldBeEqualIgnoringCase "AAb"

        "yes".shouldBeTruthy()
        "no".shouldBeFalsy()
    }

    @Test
    fun exceptions_assert() {
        val cause = NullPointerException("oops!")
        val throwable = Throwable(cause)

        // AssertJ
        AssertJ.assertThatThrownBy { throw throwable }
            .hasCauseInstanceOf(RuntimeException::class.java)
            .hasCauseExactlyInstanceOf(NullPointerException::class.java)

        AssertJ.assertThatThrownBy { error("oops!") }
            .isInstanceOf(RuntimeException::class.java)
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessageStartingWith("o")

        // kotest
        shouldThrow<RuntimeException> { error("oops!") }
            .shouldBeTypeOf<IllegalStateException>()

        shouldThrowExactly<IllegalStateException> { error("oops!") }
            .message should startWith("o")

        shouldThrowAny { throw throwable }
            .shouldHaveCauseInstanceOf<RuntimeException>()
    }

    @Test
    fun map_assert() {
        val expected = mapOf("2" to 2, "3" to 3)
        val actual = mapOf("1" to 1, "2" to 2, "3" to 3)

        // Assertj
        AssertJ.assertThat(actual).usingRecursiveComparison().isEqualTo(expected.plus("1" to 1))
        AssertJ.assertThat(actual).containsEntry("2", 2)
        AssertJ.assertThat(actual).containsAllEntriesOf(expected)
        AssertJ.assertThat(actual).containsExactlyInAnyOrderEntriesOf(expected.plus("1" to 1))
        AssertJ.assertThat(actual).containsKey("2")
        AssertJ.assertThat(actual).containsValue(2)

        AssertJ.assertThat(actual).allSatisfy { key, value ->
            if (key == "2") AssertJ.assertThat(value).isGreaterThan(1)
            if (key == "3") AssertJ.assertThat(value).isLessThan(5)
        }

        // kotest
        actual shouldBe expected.plus("1" to 1)
        actual.shouldContain("2" to 2)
        actual.shouldContainAll(expected)
        actual.shouldContainExactly(expected.plus("1" to 1))
        actual.shouldContainKey("2")
        actual.shouldContainValue(2)
        actual.shouldMatchAll(
            "2" to { it shouldBeGreaterThan 1 },
            "3" to { it shouldBeLessThan 5 }
        )
    }

    @Test
    fun recursive_assert() {
        class Address(var number: Int = 1)

        class Home(var address: Address = Address())
        class Person(
            var name: String? = null,
            var height: Float = 0.0f,
            var home: Home = Home(),
            var bestFriend: Person? = null,
        )

        val jack = Person("Jack", height = 1.80f)
        jack.home.address.number = 123

        val jackClone = Person(name = "Jack", height = 1.80f)
        jackClone.home.address.number = 123

        // cycle are handled in comparison
        jack.bestFriend = jackClone
        jackClone.bestFriend = jack

        // will fail as equals compares object references
        // AssertJ.assertThat(jack).isEqualTo(jackClone)
        // AssertJ.assertThat(jack).isEqualToComparingFieldByField(jackClone)
        // jack and jackClone are equal when doing a recursive field by field comparison
        AssertJ.assertThat(jack).usingRecursiveComparison().isEqualTo(jackClone)
    }

    @Test
    fun collection_assert() {
        val expected = listOf(1, 2, 3)
        val actual = listOf(1, 2, 3)
        val actualShuffled = listOf(1, 2, 3).shuffled()
        val actualNullable = listOf(1, 2, 3, null)

        // JUnit
        JUnit.assertIterableEquals(expected, actual)

        // AssertJ
        AssertJ.assertThat(actual).contains(2)

        AssertJ.assertThat(actual).isEqualTo(expected)
        AssertJ.assertThat(actual).containsExactlyElementsOf(expected)
        AssertJ.assertThat(actual).hasSameElementsAs(expected)

        AssertJ.assertThat(actual)
            .containsExactlyInAnyOrderElementsOf(actualShuffled)
        AssertJ.assertThat(actual.plus(5))
            .containsAll(actualShuffled)

        AssertJ.assertThat(actual).isNotEmpty
        AssertJ.assertThat(actual).isSorted

        AssertJ.assertThat(actual).allSatisfy {
            AssertJ.assertThat(it).isNotNull()
        }

        AssertJ.assertThat(actual).allMatch {
            it != 0
        }

        AssertJ.assertThat(actual).anySatisfy {
            AssertJ.assertThat(it).isGreaterThan(0)
            AssertJ.assertThat(it).isLessThan(4)
        }

        // kotest
        actual shouldContain 2
        actual.shouldNotBeEmpty()
        actual.shouldBeSorted()
        assertSoftly {
            // Гораздо лучше сообщение об ошибке в сравнении с assertj
            actual shouldContainExactly expected
            actual shouldBe expected
        }
        actual shouldContainExactlyInAnyOrder actualShuffled
        actual shouldContainInOrder expected
        actual shouldHaveAtLeastSize 2

        actual.shouldForAll {
            it shouldBeGreaterThan 0
            it shouldBeLessThan 4
        }
        actual.shouldMatchEach(
            { it shouldBeGreaterThan 0 },
            { it shouldBeExactly 2 },
            { it shouldBeLessThan 4 }
        )

        2 shouldBeIn actual

        actualNullable.shouldContainNull()

        listOf(1) shouldHaveSingleElement 1

        // Важно: в kotest гораздо меньше способов все сломать
    }

    @Test
    fun type_assert() {
        abstract class State
        class Loading : State()
        data class Content(val x: Int = 0) : State()

        val actual: State = Content()

        // AssertJ
        AssertJ.assertThat(actual).isSameAs(actual)
        AssertJ.assertThat(actual).isInstanceOf(State::class.java)
        AssertJ.assertThat(actual).isExactlyInstanceOf(Content::class.java)
        AssertJ.assertThat(actual).isNotExactlyInstanceOf(State::class.java)

        // kotest
        // Сравнивает объекты по идентичности, то есть по ===
        actual shouldBeSameInstanceAs actual

        // Важно: в kotest имеет смарт каст (из-за контракта)

        // точно принадлежит типу T
        actual.shouldBeTypeOf<Content>()
            // каст
            .x shouldBe 0

        // тк выше уже проверили тип - работает смарт каст
        actual.x
        // имеет тип T или является подклассом T
        actual.shouldBeInstanceOf<State>()
    }

    @Test
    fun soft_assert() {
        // AssertJ
        SoftAssertions.assertSoftly {
            // Важно: it придется писать всегда и легко забыть
            it.assertThat(1).isEqualTo(1)
            it.assertThat(2).isEqualTo(2)
        }

        // Kotest
        assertSoftly {
            1 shouldBe 1
            2 shouldBe 2
        }
    }

    @Test
    fun embedded_assert() {
        abstract class State
        data class Entity(val x: Int)
        data class Content(
            val id: Int = 1,
            val matrix: List<List<Int>> = listOf(
                listOf(1, 2, 3),
                listOf(4, 5, id)
            ),
            val describe: Map<String, List<Entity>> = mapOf(
                "1" to listOf(Entity(1), Entity(2)),
                "2" to listOf(Entity(1), Entity(2)),
                "3" to listOf(Entity(1), Entity(id)),
            ),
        ) : State()

        val expected = Content()
        val actual = Content(
            describe = mapOf(
                "1" to listOf(Entity(1), Entity(2)),
                "2" to listOf(Entity(1), Entity(2)),
                "3" to listOf(Entity(1), Entity(1)),
            ),
        )

        // Важно: Сообщение об ошибке не информативное
        AssertJ.assertThat(actual)
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(expected)

        AssertJ.assertThat(actual).isEqualTo(expected)
        AssertJ.assertThat(actual).isEqualToComparingFieldByField(expected)

        // kotest
        actual shouldBe expected
    }

    @Test
    fun another_kotest_assert() {
        // Dates есть еще поддержка kotlinx Datetime
        run {
            val expected = LocalDate.now()
            val actual = LocalDate.now().plusDays(1)
            expected shouldHaveSameYearAs actual
            expected shouldBeBefore actual
        }

        // Result
        run {
            val expected = Result.success(1)
            val actual = 1

            expected.shouldBeSuccess()
            expected.shouldBeSuccess(actual)
        }

        // Optional
        run {
            val expected = Optional.of(1)
            expected.shouldBePresent()
            // expected.shouldBeEmpty()
        }
    }
}
