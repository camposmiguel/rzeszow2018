import { Entity, Column, PrimaryGeneratedColumn, ManyToMany, JoinTable, OneToMany, ManyToOne } from 'typeorm';
import { Level } from 'level/level.entity';
import { User } from 'user/user.entity';

@Entity()
export class Battle {
  @PrimaryGeneratedColumn('increment') id: number;

  @Column()
  title: string;

  @Column() text: string;

  @Column() order: number;

  @ManyToOne(type => User, user => user.myBattles)
  user1: User;

  @ManyToOne(type => User, user => user.otherBattles)
  user2: User;

}