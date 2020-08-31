import React from 'react';
import { Route } from 'react-router-dom';
import { Layout } from 'antd';

import Dashboard from '../containers/dashboard/Dashboard';
import Word from '../containers/word/Word';

const { Content } = Layout;

const AppContent = () => {
  return (
    <Content style={{ margin: '24px 16px', background: '#fff', minHeight: 280 }}>
      <Route exact path="/" component={Dashboard} />
      <Route path="/word" component={Word} />
    </Content>
  );
};

export default AppContent;
