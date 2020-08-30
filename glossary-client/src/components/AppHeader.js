import React from 'react';

import { Layout } from 'antd';
import { MenuUnfoldOutlined, MenuFoldOutlined } from '@ant-design/icons';

const { Header } = Layout;

const AppHeader = ({ collapsed, onToggle }) => {
  return (
    <Header style={{ background: '#fff', padding: 0, paddingLeft: 16 }}>
      {collapsed ? (
        <MenuUnfoldOutlined
          className="trigger"
          style={{ cursor: 'pointer', fontSize: 20 }}
          onClick={onToggle}
        />
      ) : (
        <MenuFoldOutlined
          className="trigger"
          style={{ cursor: 'pointer', fontSize: 20 }}
          onClick={onToggle}
        />
      )}
    </Header>
  );
};

export default AppHeader;
