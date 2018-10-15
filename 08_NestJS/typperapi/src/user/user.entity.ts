import { Entity, Column, PrimaryGeneratedColumn, ManyToMany, JoinTable, OneToMany, ManyToOne } from 'typeorm';

@Entity()
export class User {
  @PrimaryGeneratedColumn('increment') id: number;

  @Column({ length: 100 })
  username: string;

  @Column() email: string;

  @Column() password: string;

  @Column({default: 0})
  ducks: number;

}