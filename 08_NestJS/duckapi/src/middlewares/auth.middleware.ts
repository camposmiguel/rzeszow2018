import { Middleware, NestMiddleware, Injectable } from '@nestjs/common';

import * as jwt from 'jsonwebtoken';

@Injectable()
export class AuthMiddleware implements NestMiddleware {

    constructor() {}

    resolve() {

        return(req, res, next) => {

          if (req.headers.authorization && req.headers.authorization.split(' ')[0] === 'Bearer') {
            const token = req.headers.authorization.split(' ')[1];

            const allowAll = true;
            const allowedOrigins = ['http://localhost:3000', 'http://localhost:4200', 'http://www.resucitoapp.com'];
            if (allowAll || allowedOrigins.indexOf(req.header('Origin')) > -1) {
                if (allowAll) {
                  res.setHeader('Access-Control-Allow-Origin', '*');
                } else {
                  res.setHeader('Access-Control-Allow-Origin', req.header('Origin'));
                }
                res.setHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE');
                res.setHeader('Access-Control-Allow-Headers', 'Content-Type');
                res.setHeader('Access-Control-Allow-Credentials', true);
            } else {
                return res.status(401).json('Origen no permitido');
            }

            jwt.verify(token, 'my-secret', (err, payload) => {
              if (!err) {
                // confirm identity and check user permissions
                req.payload = payload;
                next();
              } else {
                 return res.status(403).json(err);
              }
            });
          } else {
            return res.status(401).json('El token de acceso no es válido.');
          }
        };
    }
}