import React, { memo } from 'react';

const Ball = memo(({ number }) => {
  let background = 'green';

  if (number <= 10) {
    background = 'red';
  } else if (number <= 20) {
    background = 'orange';
  } else if (number <= 30) {
    background = 'yellow';
  } else if (number <= 40) {
    background = 'blue';
  }

  return (
    <div className="ball" style={{ background }}>
      {number}
    </div>
  );
});

export default Ball;
