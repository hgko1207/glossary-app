import React from 'react';
import { PageHeader } from 'antd';

const Dashboard = () => {
  return (
    <>
      <PageHeader
        className="site-page-header"
        //onBack={() => null}
        title="Dashboard"
        subTitle="This is a subtitle"
      />
    </>
  );
};

export default Dashboard;
