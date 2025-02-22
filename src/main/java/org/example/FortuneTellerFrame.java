package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.net.URL;
import javax.swing.ImageIcon;


public class FortuneTellerFrame extends JFrame {
    private JTextArea fortuneArea;
    private ArrayList<String> fortunes;
    private String lastFortune = "";
    private Random rand = new Random();

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.75), 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Fortune Teller", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        URL imageUrl = getClass().getClassLoader().getResource("images.jpeg");

        if (imageUrl == null) {
            throw new RuntimeException("Image not found! Check src/main/resources/");
        }

        ImageIcon icon = new ImageIcon(imageUrl);
        ImageIcon originalIcon = new ImageIcon(imageUrl);
        Image originalImage = originalIcon.getImage();


        int newWidth = 150;
        int newHeight = 50;
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);


        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        titleLabel.setIcon(resizedIcon);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        add(titleLabel, BorderLayout.NORTH);


        fortuneArea = new JTextArea(10, 40);
        fortuneArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        fortuneArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune");
        JButton quitButton = new JButton("Quit");

        readFortuneButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 18));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        fortunes = new ArrayList<>();
        addFortunes();

        readFortuneButton.addActionListener(e -> displayNewFortune());
        quitButton.addActionListener(e -> System.exit(0));
    }


    private void addFortunes() {
        fortunes.add("You will find something you lost. It will be in the last place you look!");
        fortunes.add("You have a great sense of humor. Please return it to the owner.");
        fortunes.add("Your future is bright… unless you forget to pay the electricity bill.");
        fortunes.add("Tomorrow, you will realize that today was not so bad after all.");
        fortunes.add("You will be hungry again in one hour. Probably sooner.");
        fortunes.add("A beautiful, smart, and loving person will be staring back at you in the mirror.");
        fortunes.add("You will be incredibly successful… in taking naps.");
        fortunes.add("A friend will bring you joy… or borrow money. Either way, joy!");
        fortunes.add("You will soon be famous… for something embarrassing.");
        fortunes.add("Your hidden talent will soon be revealed… to your own surprise.");
        fortunes.add("Life is short. Eat dessert first.");
        fortunes.add("The fortune you seek is in another cookie.");

    }
    private void displayNewFortune() {
        String newFortune;
        do {
            newFortune = fortunes.get(rand.nextInt(fortunes.size()));
        } while (newFortune.equals(lastFortune));

        lastFortune = newFortune;
        fortuneArea.append(newFortune + "\n");
    }
}
