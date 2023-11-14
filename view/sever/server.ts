/* import express from 'express';
import path from 'path';
const app = express();

app.use(
  express.static(path.join(__dirname, './'), {
    setHeaders: (res, filePath) => {
      if (filePath.endsWith('.js')) {
        res.setHeader('Content-Type', 'application/javascript');
      }
    },
  }),
);

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, './index.html'));
});

app.listen(2080, () => {
  console.log('Server is running on port 2080');
}); */