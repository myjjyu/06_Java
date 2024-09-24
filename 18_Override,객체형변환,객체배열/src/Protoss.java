public class Protoss {
  private String name;

  private int hp;

  private int speed;

  private int dps;

  /**
   * 
   * @param name
   * @param hp
   * @param speed
   * @param dps
   */
  public Protoss(String name, int hp, int speed, int dps) {
    this.name = name;
    this.hp = hp;
    this.speed = speed;
    this.dps = dps;
    System.out.printf(">>유닛이 생성되었습니다. ---> 이름: %s, 체력: %d, 공경력: %d/n", name, hp, dps);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHp() {
    return this.hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getSpeed() {
    return this.speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getDps() {
    return this.dps;
  }

  public void setDps(int dps) {
    this.dps = dps;
  }

  /**
   * 
   * @param position
   */
  public void move(String position) {
    System.out.printf("%s(이)가 %s까지 이동합니다. \n", this.name, position);
  }

  /**
   * 
   * @param target
   */
  public void attack(String target) {
    System.out.printf("%s(이)가 %s까지 이동합니다. >> 데미지: %d\n", this.name, target, this.dps);

  }

  @Override
  public String toString() {
    return "{" +
        " name='" + getName() + "'" +
        ", hp='" + getHp() + "'" +
        ", speed='" + getSpeed() + "'" +
        ", dps='" + getDps() + "'" +
        "}";
  }
}
