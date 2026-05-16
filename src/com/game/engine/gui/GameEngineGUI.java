package com.game.engine.gui;

import com.game.engine.entities.Enemy;
import com.game.engine.factory.EnemyFactory;
import com.game.engine.observer.GameObserver;
import com.game.engine.observer.GameSubject;
import com.game.engine.state.AttackState;
import com.game.engine.state.IdleState;

import javax.swing.*;
import java.awt.*;

public class GameEngineGUI extends JFrame {

    private Enemy currentEnemy;
    private final GameSubject gameEvents;
    private final JTextArea logArea;

    public GameEngineGUI() {

        setTitle("Mini Java Game Engine");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gameEvents = new GameSubject();

        gameEvents.addObserver(new GameObserver("Console Logger"));
        gameEvents.addObserver(new GameObserver("Score System"));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(
                "Mini Java Game Engine",
                SwingConstants.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(
                new GridLayout(2, 2, 10, 10));

        buttonPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton zombieButton = new JButton("Spawn Zombie");
        JButton skeletonButton = new JButton("Spawn Skeleton");
        JButton idleButton = new JButton("Set Idle State");
        JButton attackButton = new JButton("Set Attack State");

        buttonPanel.add(zombieButton);
        buttonPanel.add(skeletonButton);
        buttonPanel.add(idleButton);
        buttonPanel.add(attackButton);

        logArea = new JTextArea();

        logArea.setEditable(false);

        logArea.setFont(
                new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(logArea);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Game Logs"));

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        add(mainPanel);

        zombieButton.addActionListener(e -> spawnEnemy("Zombie"));

        skeletonButton.addActionListener(e -> spawnEnemy("Skeleton"));

        idleButton.addActionListener(e -> {

            if (currentEnemy != null) {

                currentEnemy.setState(new IdleState());

                log("Enemy state changed to IdleState");

                currentEnemy.update();

            } else {

                log("Please spawn an enemy first.");
            }
        });

        attackButton.addActionListener(e -> {

            if (currentEnemy != null) {

                currentEnemy.setState(new AttackState());

                log("Enemy state changed to AttackState");

                currentEnemy.update();

            } else {

                log("Please spawn an enemy first.");
            }
        });
    }

    private void spawnEnemy(String type) {

        currentEnemy = EnemyFactory.createEnemy(type);

        log(type + " spawned.");

        gameEvents.notifyObservers(
                type + " spawned in the game.");

        currentEnemy.update();
    }

    private void log(String message) {

        logArea.append(message + "\n");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            GameEngineGUI gui = new GameEngineGUI();

            gui.setVisible(true);
        });
    }
}