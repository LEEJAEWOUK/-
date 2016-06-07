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

	static String que[] = { "SS�� �Ϻ�����?", "������ ���ġ�� ��Ʈ�� ���ٰ� �ٽ� ���ġ�� ������ �¾��߷���?", "SS����ΰ� ��ɹ����� ���������ߴ� ��������?" };
	static String bwn[][] = { { "�����", "���س�", "����ȣ", "������" }, { "���", "�ڰ�", "������", "����" },
			{ "������", "����ȣ", "������", "������" } };
	static int awn[] = { 2, 3, 2 };// ����
	static int my_awn[] = new int[3]; // ���� �Է��� ��
	
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
		label[j].setOpaque(true); // Opaque���� true�� �̸� ������ �־�� ������ ����ȴ�.
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
			if (my_awn[i] == awn[i]) // �Է��� ��� ������ ��
				right++;
		}
		System.out.println(right + "�� �¾ҽ��ϴ�."); // ���� ���� ���

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
				btn[i].setVisible(false); // ��ư ������ �ʰ� �ϱ�
			}
			label[j].setVisible(false); // �����ѱ��

			j--;

			if (j == -1)
				j = 0;

			Question();

		}

		if (e.getSource().equals(move)) {
			for (i = 0; i < 4; i++) {
				btn[i].setVisible(false); // ��ư ������ �ʰ� �ϱ�
			}
			label[j].setVisible(false);

			j++;

			if (j == 3)
				finish();

			Question();
		}
	}
}