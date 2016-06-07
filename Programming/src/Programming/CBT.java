package Programming;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class CBT extends JFrame implements ActionListener {

	JFrame frm = new JFrame("CBT!");
	JRadioButton btn[] = new JRadioButton[4];
	JButton move;
	JButton before;
	JLabel label[] = new JLabel[3];

	static int i = 0, j = 0;
	static int right = 0;

	static String que[] = { "SS의 일베충은?", "스스를 통수치고 루트로 갔다가 다시 통수치고 스스로 온씨발련은?", "SS보험두고 기능반으로 내뺄려고했던 개새끼는?" };
	static String bwn[][] = { { "이재욱", "이준노", "김준호", "문희주" }, { "허람", "박건", "서성훈", "고경민" },
			{ "오현우", "김준호", "서성훈", "조혜선" } };
	static int awn[] = { 2, 3, 2 };// 정답
	static int my_awn[] = new int[3]; // 내가 입력할 답
	
	static int overlap=0;

	public CBT() {
		frm.setSize(1920, 1040);
		frm.setVisible(true);
		frm.setLayout(null);

		Button();
		Label();
		before();
		next();
	}

	void before() {

		frm.add(before = new JButton("<<"));
		before.setBounds(75, 600, 100, 50);
		before.addActionListener(this);

	}

	void next() {
		frm.add(move = new JButton(">>"));
		move.setBounds(200, 600, 100, 50);
		move.addActionListener(this);
	}

	void Label() {

		frm.add(label[j] = new JLabel(que[j]));

		label[j].setBounds(75, 30, 950, 250);
		label[j].setOpaque(true); // Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		label[j].setBackground(Color.pink);

	}

	void Button() {

		for (i = 0; i < 4; i++) {
			frm.add(btn[i] = new JRadioButton(bwn[j][i]));
			btn[i].addActionListener(this);
			btn[i].setBounds(75 + (300 * i), 400, 100, 50);
		}
	}

	void finish() {
		for (i = 0; i < 3; i++) {
			if (my_awn[i] == awn[i]) // 입력한 답과 정답을 비교
				right++;
		}
		System.out.println(right + "개 맞았습니다."); // 맞은 개수 출력

		System.exit(0);
	}

	void Question() {
		System.out.println("Question" + j);
		Button();
		Label();
	}

	public static void main(String[] args) {
		new CBT();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (i = 0; i < 4; i++) {
			if (e.getSource().equals(btn[i])) {
				overlap=1;
			}
		}


		if (j == 0) {
			for (i = 0; i < 4; i++) {
				if (e.getSource().equals(btn[i]))
					my_awn[j] = i + 1;
			}
		}

		else if (j == 1) {
			for (i = 0; i < 4; i++) {
				if (e.getSource().equals(btn[i]))
					my_awn[j] = i + 1;
			}
		}

		else if (j == 2) {
			for (i = 0; i < 4; i++) {
				if (e.getSource().equals(btn[i]))
					my_awn[j] = i + 1;
			}
		}

		if (e.getSource().equals(before)) {
			for (i = 0; i < 4; i++) {
				btn[i].setVisible(false); // 버튼 보이지 않게 하기
			}
			label[j].setVisible(false); // 문제넘기기

			j--;

			if (j == -1)
				j = 0;

			Question();

		}

		if (e.getSource().equals(move)) {
			for (i = 0; i < 4; i++) {
				btn[i].setVisible(false); // 버튼 보이지 않게 하기
			}
			label[j].setVisible(false);

			j++;

			if (j == 3)
				finish();

			Question();
		}
	}
}