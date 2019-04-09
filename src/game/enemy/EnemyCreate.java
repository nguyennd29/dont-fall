package game.enemy;

import action.*;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyCreate extends GameObject {

    public Random random;

    public EnemyCreate() {
        this.random = new Random();
        this.configAction();
    }

    public void configAction() {
        List<Enemies> enemies_1 = new ArrayList<>();
        List<Enemies> enemies_2 = new ArrayList<>();
        List<Enemies> enemies_3 = new ArrayList<>();
        List<Enemies> enemies_4 = new ArrayList<>();

        Action createAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                Enemies enemies1 = GameObjectManager.instance.recycle(Enemies.class);
                Enemies enemies2 = GameObjectManager.instance.recycle(Enemies.class);
                Enemies enemies3 = GameObjectManager.instance.recycle(Enemies.class);
                Enemies enemies4 = GameObjectManager.instance.recycle(Enemies.class);
                enemies_1.add(enemies1);
                enemies_2.add(enemies2);
                enemies_3.add(enemies3);
                enemies_4.add(enemies4);
                return true;
            }
        };

        Action waitAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                enemies_1.removeIf(enemies1 -> !enemies1.isAlive);
                enemies_2.removeIf(enemies2 -> !enemies2.isAlive);
                enemies_3.removeIf(enemies3 -> !enemies3.isAlive);
                enemies_4.removeIf(enemies4 -> !enemies4.isAlive);
                return true;
            }
        };

        Action setPositionAction1 = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemies_1.size()-1; i++) {
                    for (int j = 2; j < enemies_1.size(); j++) {
                        enemies_1.get(i).position.set(2200 + 1000 * i, 1100);
                        enemies_1.get(j).position.set(2200, 1100 + 600 * j);
                    }
                }
                return true;
            }
        };

        Action setPositionAction2 = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemies_2.size()-1; i++) {
                    for (int j = 2; j < enemies_2.size(); j++) {
                        enemies_2.get(i).position.set(5150 + 900 * i, 1100);
                        enemies_2.get(j).position.set(5150, 1100 + 600 * j);
                    }
                }
                return true;
            }
        };

        Action setPositionAction3 = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemies_3.size()-1; i++) {
                    for (int j = 2; j < enemies_3.size(); j++) {
                        enemies_3.get(i).position.set(2200 + 1000 * i, 4000);
                        enemies_3.get(j).position.set(2200, 4000 + 600 * j);
                    }
                }
                return true;
            }
        };

        Action setPositionAction4 = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemies_4.size()-1; i++) {
                    for (int j = 2; j < enemies_4.size(); j++) {
                        enemies_4.get(i).position.set(5150 + 900 * i, 4000);
                        enemies_4.get(j).position.set(5150, 4000 + 600 * j);
                    }
                }
                return true;
            }
        };

        Action moveLeftAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemies_1.size(); i++) {
                    enemies_1.get(i).velocity.set(-5, 0);
                }
                for (int i = 0; i < enemies_2.size(); i++) {
                    enemies_2.get(i).velocity.set(-5, 0);
                }
                for (int i = 0; i < enemies_3.size(); i++) {
                    enemies_3.get(i).velocity.set(-5, 0);
                }
                for (int i = 0; i < enemies_4.size(); i++) {
                    enemies_4.get(i).velocity.set(-5, 0);
                }
                return true;
            }
        };

        Action moveRightAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemies_1.size(); i++) {
                    enemies_1.get(i).velocity.set(5, 0);
                }
                for (int i = 0; i < enemies_2.size(); i++) {
                    enemies_2.get(i).velocity.set(5, 0);
                }
                for (int i = 0; i < enemies_3.size(); i++) {
                    enemies_3.get(i).velocity.set(5, 0);
                }
                for (int i = 0; i < enemies_4.size(); i++) {
                    enemies_4.get(i).velocity.set(5, 0);
                }
                return true;
            }
        };

        Action stopAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                for (int i = 0; i < enemies_1.size(); i++) {
                    enemies_1.get(i).velocity.set(0, 0);
                }
                for (int i = 0; i < enemies_2.size(); i++) {
                    enemies_2.get(i).velocity.set(0, 0);
                }
                for (int i = 0; i < enemies_3.size(); i++) {
                    enemies_3.get(i).velocity.set(0, 0);
                }
                for (int i = 0; i < enemies_4.size(); i++) {
                    enemies_4.get(i).velocity.set(0, 0);
                }
                return true;
            }
        };

        Action shootAction = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                EnemyShoot enemyShoot = new EnemyShoot();

                for (int i = 0; i < enemies_1.size()-1; i++) {
                    enemyShoot.run(enemies_1.get(i));
                }
                for (int i = 0; i < enemies_2.size(); i++) {
                    enemyShoot.run(enemies_2.get(i));
                }
                for (int i = 0; i < enemies_3.size(); i++) {
                    enemyShoot.run(enemies_3.get(i));
                }
                for (int i = 0; i < enemies_4.size(); i++) {
                    enemyShoot.run(enemies_4.get(i));
                }
                return true;
            }
        };


        this.addAction(
                new LimitAction(1,
                        new SequenceAction(
                                createAction, createAction, createAction,
                                setPositionAction1, setPositionAction2, setPositionAction3, setPositionAction4,
                                new RepeatActionForever(
                                        new SequenceAction(
                                                moveLeftAction, new WaitAction(10),
                                                stopAction,new WaitAction(30),
                                                shootAction, new WaitAction(30),
                                                moveRightAction, new WaitAction(60),
                                                stopAction,new WaitAction(30),
                                                shootAction, new WaitAction(30),
                                                moveLeftAction, new WaitAction(50),
                                                waitAction
                                        )
                                )
                        )
                )
        );
    }
}