package com.megaitacademy.packageex.impl;

import com.megaitacademy.packageex.IFight;
import com.megaitacademy.packageex.IMove;
import com.megaitacademy.packageex.Unit;


public class Monster extends Unit implements IMove,IFight {

  public Monster(String name, int hp, int speed, int dps) {
    super(name, hp, speed, dps);
  }

  @Override
  public void jump() {
    System.out.printf("[Monster] %s가 점프합니다\n", this.getName());
    
  }

  @Override
  public void run() {
    System.out.printf("[Monster] %s가 주변을 뛰면서 배회합니다\n", this.getName());
    
  }

  @Override
  public void walk() {
    System.out.printf("[Monster] %s가 주변을 배회합니다\n", this.getName());
    
  }

  @Override
  public void attack() {
    System.out.printf("[Monster] %s가 %d의 힘으로 주인공을 공격합니다\n", this.getName(), this.getDps());
    
  }

  @Override
  public void defense() {
    System.out.printf("[Monster] %s가 주인공의 공격을 방어합니다\n", this.getName());
    
  }

  @Override
  public void evasion() {
    System.out.printf("[Monster] %s가 주인공의 공격을 회피 합니다\n", this.getName());
    
  }
  
}
