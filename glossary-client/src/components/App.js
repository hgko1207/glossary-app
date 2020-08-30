import React, { useState, useCallback } from 'react';
import { BrowserRouter as Router } from 'react-router-dom';
import { Layout } from 'antd';

import SideMenu from './SideMenu';
import AppHeader from './AppHeader';
import AppContent from './AppContent';
import AppFooter from './AppFooter';

import 'antd/dist/antd.css';
import './App.css';

const App = () => {
  const [collapsed, setCollapsed] = useState(false);

  const onCollapse = useCallback((collapsed) => {
    setCollapsed(collapsed);
  }, []);

  const toggle = useCallback(
    (e) => {
      setCollapsed(!collapsed);
    },
    [collapsed]
  );

  return (
    <Router>
      <Layout style={{ minHeight: '100vh' }}>
        <SideMenu collapsed={collapsed} onCollapse={onCollapse} />
        <Layout>
          <AppHeader collapsed={collapsed} onToggle={toggle} />
          <AppContent />
          <AppFooter />
        </Layout>
      </Layout>
    </Router>
  );
};

export default App;
