import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { User } from './user.entity';
import { Repository } from 'typeorm';
import { Ranking } from './ranking.interface';

@Injectable()
export class UserService {
    constructor(
        @InjectRepository(User)
        private readonly userRepository: Repository<User>,
      ) {}

      /*******************************************************
       * Get all Users
       *******************************************************/
      async getAllUsers(): Promise<User[]> {
        return await this.userRepository.find();
      }

      /*******************************************************
       * Get Rank
       *******************************************************/
      async getRanking(): Promise<Ranking[]> {
        const users = await this.userRepository.createQueryBuilder('user').orderBy('user.ducks', 'DESC').getMany();
        const ranking: Ranking[] = new Array();
        users.forEach(u => {
          ranking.push({ducks: u.ducks, username: u.username});
        });

        return ranking;
      }

      /*******************************************************
       * Get One User by Id
       *******************************************************/

      async getUser(id: any): Promise<User> {
        return await this.userRepository.findOne(id);
      }

      /*******************************************************
       * Create User
       *******************************************************/

      async createUser(us: string, em: string, pwd: string): Promise<User> {
        const userExist = await this.userRepository.createQueryBuilder('user').where(`user.email=${em}`).getOne();
        if (userExist) {
          return null;
        } else {
          const newUser = new User();
          newUser.username = us;
          newUser.email = em;
          newUser.password = pwd;
          return await this.userRepository.save(newUser);
        }
      }

      /*******************************************************
       * Update User
       *******************************************************/

      async updateUser(id: string, us: string, em: string, pwd: string, nducks: number): Promise<User> {
        const userToUpdate = await this.userRepository.findOne(id);
        userToUpdate.username = us;
        userToUpdate.email = em;
        userToUpdate.password = pwd;
        userToUpdate.ducks = nducks;
        return await this.userRepository.save(userToUpdate);
      }

      /*******************************************************
       * Update Rank
       *******************************************************/

      async updateRank(id: string, nducks: number): Promise<User> {
        const userToUpdate = await this.userRepository.findOne(id);
        userToUpdate.ducks = nducks;
        return await this.userRepository.save(userToUpdate);
      }

      /*******************************************************
       * Delete User
       *******************************************************/

      async deleteUser(id: string): Promise<User> {
        const userToDelete = await this.userRepository.findOne(id);
        return await this.userRepository.remove(userToDelete);
      }

}
