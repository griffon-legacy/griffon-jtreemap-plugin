/*
 * Copyright 2009-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Hackergarten
 */
class JtreemapGriffonPlugin {
    // the plugin version
    String version = '1.0.0'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.0.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [swing: '1.0.0']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = ['swing']
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-jtreemap-plugin'

    List authors = [
        [
            name: 'Hackergarten',
            email: 'hackergarten@hackergarten.net'
        ]
    ]
    String title = 'TreeMap component'
    String description = '''
[JTreeMap][1] is an open-source library that graphically represents a hierarchical structure. Typically, the hierarchy will involve a
tree of nodes of different sizes and different colours. 

This plugin was created by the [Hackergarten][2] programming group, at the [Canoo Engineering AG][3] world headquarters in Basel Switzerland.

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node*  | *Type*                           |
| ------- | -------------------------------- |
| treeMap | `net.sf.jtreemap.swing.JTreeMap` |

You can use the treemap node in views as shown in the following example.

__View__

        application(title: 'JTreeMap demo',
          pack:true,
          locationByPlatform:true,
          iconImage: imageIcon('/griffon-icon-48x48.png').image,
          iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                       imageIcon('/griffon-icon-32x32.png').image,
                       imageIcon('/griffon-icon-16x16.png').image]) {
            borderLayout()
            button(text: 'Select Directory', constraints: NORTH, actionPerformed: controller.chooseFile)
            treemap(id: 'hackergartenTreeMap', constraints: CENTER)
        }

You can then reference the treemap node from your controller and set the tree nodes.

__Controller__

        import net.sf.jtreemap.swing.JTreeMap
        import net.sf.jtreemap.swing.TreeMapNode
        import net.sf.jtreemap.swing.TreeMapNodeBuilder
        import net.sf.jtreemap.swing.ValuePercent

        class SampleController {
            def view

            def chooseFile = {
                TreeMapNode root = null

                TreeMapNodeBuilder builder = new TreeMapNodeBuilder()

                TreeMapNode continentEurope = builder.buildBranch("Europe", null)
                TreeMapNode countryCH = builder.buildBranch("Switzerland", continentEurope)

                builder.buildLeaf("Basel", 120, new ValuePercent(120 / 110), countryCH)
                builder.buildLeaf("Zuerich", 200, new ValuePercent(200 / 240), countryCH)

                TreeMapNode countryDE = builder.buildBranch("Germany", continentEurope)
                builder.buildLeaf("Bayern", 300, new ValuePercent(300 / 200), countryDE)

                root = builder.root

                execInsideUISync {
                    view.hackergartenTreeMap.root = root
                }
            }
        }

[1]: http://jtreemap.sourceforge.net/
[2]: http://www.hackergarten.net/
[3]: http://www.canoo.com/
'''
}