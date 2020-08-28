import React from 'react';
import { Layout } from 'antd';
import "antd/dist/antd.css";
import './App.css';

const { Header, Content } = Layout;

function App() {
  return (
    <Layout className="App">
      <Header>Header</Header>
      <Content>Content</Content>
    </Layout>
  );
}

export default App;
