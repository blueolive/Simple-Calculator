package mengwu.project.calculator;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity {
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

	private String resultStr = "";
	private String oneStrFactor = "";
	private double oneNumFactor = 0.0;

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
			inputText.setText('0');
		}
	}

	class figure1BtnListener implements OnClickListener {
		public void onClick(View v) {
			inputText.setText('1');
		}
	}

	class figure2BtnListener implements OnClickListener {
		public void onClick(View v) {
			inputText.setText('2');
		}
	}

	class figure3BtnListener implements OnClickListener {
		public void onClick(View v) {
			inputText.setText('3');
		}
	}

	class figure4BtnListener implements OnClickListener {
		public void onClick(View v) {
			inputText.setText('4');
		}
	}

	class figure5BtnListener implements OnClickListener {
		public void onClick(View v) {
			inputText.setText('5');
		}
	}

	class figure6BtnListener implements OnClickListener {
		public void onClick(View v) {
			inputText.setText('6');
		}
	}

	class figure7BtnListener implements OnClickListener {
		public void onClick(View v) {
			inputText.setText('7');
		}
	}

	class figure8BtnListener implements OnClickListener {
		public void onClick(View v) {
			inputText.setText('8');
		}
	}

	class figure9BtnListener implements OnClickListener {
		public void onClick(View v) {
			inputText.setText('9');
		}
	}

	class signPlusBtnListener implements OnClickListener {
		public void onClick(View v) {
			// inputText.setText('+');
			Toast.makeText(CalculatorActivity.this, "+", Toast.LENGTH_SHORT);
			oneStrFactor = inputText.getText().toString();
			oneNumFactor = Double.parseDouble(oneStrFactor);
		}
	}

	class signMinusBtnListener implements OnClickListener {
		public void onClick(View v) {
			// inputText.setText('-');
			Toast.makeText(CalculatorActivity.this, "-", Toast.LENGTH_SHORT);
		}
	}

	class signMultipleBtnListener implements OnClickListener {
		public void onClick(View v) {
			// inputText.setText('*');
			Toast.makeText(CalculatorActivity.this, "*", Toast.LENGTH_SHORT);
		}
	}

	class signDivieBtnListener implements OnClickListener {
		public void onClick(View v) {
			// inputText.setText('/');
			Toast.makeText(CalculatorActivity.this, "/", Toast.LENGTH_SHORT);
		}
	}

	class equalBtnListen implements OnClickListener {
		public void onClick(View v) {
			int charAtPos = resultStr.length();
			int time = 0;
			char lastlyChar = ' ';
			while (charAtPos > 0) {
				if ('+' != lastlyChar || '-' != lastlyChar || '*' != lastlyChar || '/' != lastlyChar) {

				}
			}
		}
	}

	private double getfactor(char charFactor) {
		return 1.0;
	}

	private double factorStack(double factor) {
		
		return 1.0;
	}
	private Character getCurrentSign() {
		String tempStr = inputText.getText().toString();
		int currentStrLenth = inputText.getText().length();
		Character lastlySymbol = tempStr.charAt(currentStrLenth);
		if (0 == currentStrLenth) {
			return '+';
		} else {
			if (lastlySymbol == '+' || lastlySymbol == '-' || lastlySymbol == '*' || lastlySymbol == '/') {
				return tempStr.charAt(currentStrLenth);
			} else {
				return lastlySymbol;
			}

		}
	}

	private String addStr(char btnValue) {
		int currentStrLenth = inputText.getText().length();
		if (0 == currentStrLenth) {
			if ('+' == btnValue || '*' == btnValue || '/' == btnValue) {
				return "";
			}
		}
		Log.i("info", resultStr);
		return resultStr += btnValue;
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