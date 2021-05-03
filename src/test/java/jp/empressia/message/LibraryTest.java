package jp.empressia.message;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Locale;

import org.junit.jupiter.api.Test;

/** ライブラリのテストです。 */
public class LibraryTest {

	/** メッセージプロパティを読み込める。 */
	@Test
	public void loadResource() {
		DefaultMessageProvider messageProvider = new DefaultMessageProvider();
		String m = messageProvider.get("TEST0000", Locale.getDefault());
		assertAll(
			() -> assertThat("メッセージを取得できる。", m, is(notNullValue()))
		);
	}

}
