package mengwu.project.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity {
	private static final String TAG = "CALCULATOR_ACITVITY";
	TextView inputText = null;
	Button figure0Btn = null;
	Button figure1Btn = null;
	Button figure2Btn = null;
	Button figure3Btn = null;
	Button figure4Btn = null;
	Button figure5Btn = null;
	Button figure6Btn = null;
	Button figure7Btn = null;
	Button figure8Btn = null;
	Button figure9Btn = null;
	Button signPlusBtn = null;
	Button signMinusBtn = null;
	Button signMultipleBtn = null;
	Button signDivieBtn = null;
	Button equalBtn = null;
	Button deleteBtn = null;
	Button pointBtn = null;

	private String currentShowStr = "";
	private String oneStrFactor = "";
	private double oneFactor = 0.0;
	private double oneNumFactor = 0.0;
	boolean isLocked = false; // 符号开关
	boolean isFirstInput = true; // 首次输入开关
	char operator = ' '; // 记录当前的操作符

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		findView();
		setOnclickListener();
	}

	private void findView() {
		inputText = (TextView) findViewById(R.id.inputText);
		figure0Btn = (Button) findViewById(R.id.figure_0);
		figure1Btn = (Button) findViewById(R.id.figure_1);
		figure2Btn = (Button) findViewById(R.id.figure_2);
		figure3Btn = (Button) findViewById(R.id.figure_3);
		figure4Btn = (Button) findViewById(R.id.figure_4);
		figure5Btn = (Button) findViewById(R.id.figure_5);
		figure6Btn = (Button) findViewById(R.id.figure_6);
		figure7Btn = (Button) findViewById(R.id.figure_7);
		figure8Btn = (Button) findViewById(R.id.figure_8);
		figure9Btn = (Button) findViewById(R.id.figure_9);
		signPlusBtn = (Button) findViewById(R.id.plus_sign);
		signMinusBtn = (Button) findViewById(R.id.minus_sign);
		signMultipleBtn = (Button) findViewById(R.id.multiple_sign);
		signDivieBtn = (Button) findViewById(R.id.division_sign);
		deleteBtn = (Button) findViewById(R.id.delete);
		pointBtn = (Button) findViewById(R.id.point);
		equalBtn = (Button) findViewById(R.id.equal);
	}

	private void setOnclickListener() {
		figure0Btn.setOnClickListener(new figure0BtnListener());
		figure1Btn.setOnClickListener(new figure1BtnListener());
		figure2Btn.setOnClickListener(new figure2BtnListener());
		figure3Btn.setOnClickListener(new figure3BtnListener());
		figure4Btn.setOnClickListener(new figure4BtnListener());
		figure5Btn.setOnClickListener(new figure5BtnListener());
		figure6Btn.setOnClickListener(new figure6BtnListener());
		figure7Btn.setOnClickListener(new figure7BtnListener());
		figure8Btn.setOnClickListener(new figure8BtnListener());
		figure9Btn.setOnClickListener(new figure9BtnListener());
		signPlusBtn.setOnClickListener(new signPlusBtnListener());
		signMinusBtn.setOnClickListener(new signMinusBtnListener());
		signMultipleBtn.setOnClickListener(new signMultipleBtnListener());
		signDivieBtn.setOnClickListener(new signDivieBtnListener());
	}

	class figure0BtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('0');
			isLocked = false;
		}
	}

	class figure1BtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('1');
			isLocked = false;
		}
	}

	class figure2BtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('2');
			isLocked = false;
		}
	}

	class figure3BtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('3');
			isLocked = false;
		}
	}

	class figure4BtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('4');
			isLocked = false;
		}
	}

	class figure5BtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('5');
			isLocked = false;
		}
	}

	class figure6BtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('6');
			isLocked = false;
		}
	}

	class figure7BtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('7');
			isLocked = false;
		}
	}

	class figure8BtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('8');
			isLocked = false;
		}
	}

	class figure9BtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('9');
			isLocked = false;
		}
	}

	class pointBtnListener implements OnClickListener {
		public void onClick(View v) {
			addStr('.');
			isLocked = false;
		}
	}

	class signPlusBtnListener implements OnClickListener {
		public void onClick(View v) {
			Toast.makeText(CalculatorActivity.this, "+", Toast.LENGTH_SHORT).show();
			currentShowStr = inputText.getText().toString();
			if (!isLocked) {
				// 第一次计算
				if (isFirstInput) {
					if (null == currentShowStr) {
						operator = '+';
					}
					oneFactor = 0.0;
				} else { // 非第一次计算
					double currentShowValue = Double.parseDouble(currentShowStr);
					if ('+' == operator) {
						oneFactor += currentShowValue;
					}
					if ('-' == operator) {
						oneFactor -= currentShowValue;
					}
					if ('*' == operator) {
						oneFactor *= currentShowValue;
					}
					if ('/' == operator) {
						if (0 == currentShowValue) {
							Toast.makeText(CalculatorActivity.this, "Divisor can not be zero",
									Toast.LENGTH_SHORT).show();
							inputText.setText(null);
							// isFirstInput = true;
							oneFactor = Double.parseDouble(inputText.getText().toString());
						} else {
							oneFactor /= currentShowValue;
						}
					}
				}
			}
			isLocked = true;
		}
	}

	class signMinusBtnListener implements OnClickListener {
		public void onClick(View v) {
			Toast.makeText(CalculatorActivity.this, "-", Toast.LENGTH_SHORT).show();
		}
	}

	class signMultipleBtnListener implements OnClickListener {
		public void onClick(View v) {
			Toast.makeText(CalculatorActivity.this, "*", Toast.LENGTH_SHORT).show();
		}
	}

	class signDivieBtnListener implements OnClickListener {
		public void onClick(View v) {
			Toast.makeText(CalculatorActivity.this, "/", Toast.LENGTH_SHORT).show();
		}
	}

	class equalBtnListen implements OnClickListener {
		public void onClick(View v) {
			int charAtPos = currentShowStr.length();
			int time = 0;
			char lastlyChar = ' ';
			while (charAtPos > 0) {
				if ('+' != lastlyChar || '-' != lastlyChar || '*' != lastlyChar || '/' != lastlyChar) {

				}
			}
		}
	}

	private Character getCurrentSign() {
		String tempStr = inputText.getText().toString();
		int currentShowStrLenth = inputText.getText().length();
		Character lastlySymbol = tempStr.charAt(currentShowStrLenth);
		if (0 == currentShowStrLenth) {
			return '+';
		} else {
			if (lastlySymbol == '+' || lastlySymbol == '-' || lastlySymbol == '*' || lastlySymbol == '/') {
				return tempStr.charAt(currentShowStrLenth);
			} else {
				return lastlySymbol;
			}

		}
	}

	private String addStr(char btnValue) {
		Log.i(TAG, currentShowStr);
		return currentShowStr += btnValue;
	}

	private String lastlyContext(Character symbol, String factorStr) {
		String tempStr = inputText.getText().toString();
		if (0 == inputText.getText().length()) {
			return factorStr;
		} else {
			return tempStr += (symbol + factorStr);
		}

	}
}
